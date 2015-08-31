package com.ozzy.bcsproject.tickerservice;

import javax.xml.bind.annotation.XmlRootElement;
//import java.util.Date;

import org.joda.time.*;

@XmlRootElement
public class ErrorDetail
{

    private String title;
    private int status;
    private String detail;
    private DateTime timeStamp;
    private String errorMessage;

    public ErrorDetail()
    {
        timeStamp = DateTime.now();
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public DateTime getTimeStamp()
    {
        return timeStamp;
    }

    public void setTimeStamp(DateTime timeStamp)
    {
        this.timeStamp = timeStamp;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }
}
