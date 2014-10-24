/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.web.mgr;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import mgn.obj.cal.calendarBean;
import mgn.obj.cal.calendarObj;
import mgn.obj.cal.calendarSql;
import mgn.obj.lookup.mgnLookupBean;
import mgn.obj.lookupSys.mgnSysLookupObj;
import obj.db.v1.dbMgrInterface;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author lmeans
 */
public class calObjMgr implements Serializable, mgnInterface {

    public static final String
            newCalEvent = "./cal/newCalEvent.xhtml",
            dispCalendar = "./cal/dispCalendar.xhtml";
    private mgnMgrObjInterface iface;
    private calendarBean calendarBean;
    private List<mgnLookupBean> dept;
    private int calType = 0;
    private Date startDate, endDate;
    private String DeptList = null;
    private ScheduleModel eventModel;
    public  final Logger logger = (Logger) LoggerFactory.getLogger(calObjMgr.class);

    public calObjMgr(mgnMgrObjInterface i) {
        iface = i;
       

    }

    @Override
    public String getURL() {
        return dispCalendar;
    }

    @Override
    public void cleanup() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void setDateRange(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.DAY_OF_MONTH, Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));
        cal.add(Calendar.DATE, -7);
        startDate = cal.getTime();
        cal.add(Calendar.DATE, 67);
        endDate = cal.getTime();
        System.err.println(startDate.toString());
        System.err.println(endDate.toString());
    }
    private String getActiveDeptList() {
        if (DeptList == null) {
            DeptList = "-20";
            for (mgnLookupBean x : getDept()) {
                DeptList += "," + x.getLookupId();
            }
        }
        return DeptList;
    }

    public ScheduleModel genEventModel() {
        if (eventModel == null) {
            setScheduleModel();
        }
        return eventModel;
    }

    

    public void addEvent(){
        calendarBean = null;
       iface.forwardCntr(newCalEvent);
    }
    public void saveEvent() {
        calendarObj.saveCalBean(this.getCalendarBean(), iface.getObj());
        if (calendarBean.getCalType() == 0){
            setScheduleModel();
            iface.forwardCntr(dispCalendar);
        }
        
    }

    public void cancelEvent() {

    }

    /**
     * @return the calendarBean
     */
    public calendarBean getCalendarBean() {
        if (calendarBean == null) {
            calendarBean = new calendarBean();
            calendarBean.setStartDate(Calendar.getInstance().getTime());
            calendarBean.setEnddate(Calendar.getInstance().getTime());
            calendarBean.setCalType(calType);
            calendarBean.setUserId(iface.getUser().getCustId());
        }
        return calendarBean;
    }

    /**
     * @return the dept
     */
    public List<mgnLookupBean> getDept() {
        if (dept == null) {
            dept = mgnSysLookupObj.getSysLookupList(2, iface.getObj());
        }
        return dept;
    }
    
    //initialDate="#{soulPurposeMgr.cal.currentDate}"
    // update="soulScheduleEdit_ID, soulClientWorkshopEdit_ID,soulScheduleEditWorkshop_ID"
    public void onDateSelectMonth(SelectEvent selectEvent) {  
         Date curr = (Date) selectEvent.getObject();
       // calendarBean = null;
       // this.getCalendarBean().setStartDate(curr);
       // this.getCalendarBean().setEnddate(curr);
       // iface.forwardCntr(newCalEvent);
    }
    // update="soulScheduleEdit_ID, soulClientWorkshopEdit_ID,soulScheduleEditWorkshop_ID"
    public void onEventSelectMonth(SelectEvent selectEvent) {  
       // views = var.calWeekVal;
       // currentDate = (Date) selectEvent.getObject();
       // iface.forwardSetCenter(calWeek);
        
    }
    public void setScheduleModel() {
        if (this.startDate == null)setDateRange();
        eventModel = new DefaultScheduleModel();
        CachedRowSet rs = null;
        try {
            rs = iface.getObj().getCachedRowSet(calendarSql.getCalSelectBydate(getActiveDeptList()),
                    new Object[]{
                        startDate, endDate, 0, 
                    });
           setScheduleModel(true,rs);
            rs = iface.getObj().getCachedRowSet(calendarSql.getCalSelectBydateNext(getActiveDeptList()),
                    new Object[]{
                        endDate, 0, startDate, endDate
                    });
            setScheduleModel(false,rs);
        } catch (Exception ex) {
            eventModel = null;
            logger.error(ex.toString());
        } 
    }
    private void setScheduleModel(boolean currEvent, CachedRowSet rs){
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy");
        try {
            DefaultScheduleEvent ex;
            String pre= (currEvent== true ? "":"*("),
                    post =(currEvent == true ? "":")");
            while (rs.next()) {
                pre = currEvent == true ? "": pre+" "+sdf.format(rs.getDate(13))+" ";
                if (currEvent){
                    ex = new DefaultScheduleEvent( rs.getString(3), rs.getDate(5), rs.getDate(6));
                } else {
                    ex = new DefaultScheduleEvent( pre+rs.getString(3)+post, rs.getDate(13), rs.getDate(13));
                }
                ex.setAllDay(false);
                eventModel.addEvent(ex);
            }
        } catch (Exception ex) {
            eventModel = null;
            logger.error(ex.toString());
        } finally {
            iface.getObj().closeCachedRowSet(rs);
        }
    }

}
