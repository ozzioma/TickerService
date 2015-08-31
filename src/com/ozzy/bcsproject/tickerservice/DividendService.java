package com.ozzy.bcsproject.tickerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ozzy on 007, Jul 07, 2015.
 */
@RestController
@RequestMapping("/payments")
public class DividendService
{

    private final TickerRepository dataService;

    @Autowired
    public DividendService(TickerRepository dataRepo)
    {
        this.dataService = dataRepo;
    }

    @RequestMapping("/{symbol}")
    @ResponseBody
    public ResponseEntity<?> getAllPaymentsForSymbol(@PathVariable("symbol") String symbol)
    {
        List<TickerDividend> payments = null;
        DividendPayments response = null;

        try
        {
            payments = dataService.getAllDividends(symbol);
            response = new DividendPayments();
            response.setPayments(payments);

        } catch (SQLException e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (!payments.isEmpty())
        {
            return new ResponseEntity<DividendPayments>(response, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }


    @RequestMapping("/{symbol}/{year}")
    @ResponseBody
    public ResponseEntity<?> getPaymentsByYear(@PathVariable("symbol") String symbol,
                                             @PathVariable("year") int year)
    {
        if (year < 1980 || year > 2015)
        {
            ErrorDetail error = new ErrorDetail();
            error.setTitle("year " + year);
            error.setErrorMessage("Validation failed");
            error.setDetail("year must be between 1980 and 2015");

            return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        List<TickerDividend> payments = null;
        DividendPayments response = null;

        try
        {
            payments = dataService.getDividendsByYear(symbol,year);
            response = new DividendPayments();
            response.setPayments(payments);

        } catch (SQLException e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (!payments.isEmpty())
        {
            return new ResponseEntity<DividendPayments>(response, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

}
