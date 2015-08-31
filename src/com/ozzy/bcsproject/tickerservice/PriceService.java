package com.ozzy.bcsproject.tickerservice;

//import com.wordnik.swagger.annotations.Api;
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
//@Api(basePath = "/prices", value = "Ticker price service", description = "Stock ticker historical price service",
//        produces = "application/json,application/xml")
@RestController
@RequestMapping("/prices")
public class PriceService
{

    private final TickerRepository dataService;

    @Autowired
    public PriceService(TickerRepository dataRepo)
    {
        this.dataService = dataRepo;
    }

    @RequestMapping("/{symbol}")
    @ResponseBody
    public ResponseEntity<?> getAllPricesForSymbol(@PathVariable("symbol") String symbol)
    {
        List<TickerPrice> prices = null;
        TickerPrices response = null;

        try
        {
            prices = dataService.getAllPrices(symbol);
            response = new TickerPrices();
            response.setPrices(prices);

        } catch (SQLException e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (!prices.isEmpty())
        {
            return new ResponseEntity<TickerPrices>(response, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }


    @RequestMapping("/{symbol}/{year}")
    @ResponseBody
    public ResponseEntity<?> getPricesByYear(@PathVariable("symbol") String symbol,
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

        List<TickerPrice> prices = null;
        TickerPrices response = null;

        try
        {
            prices = dataService.getPricesByYear(symbol, year);
            response = new TickerPrices();
            response.setPrices(prices);

        } catch (SQLException e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (!prices.isEmpty())
        {
            return new ResponseEntity<TickerPrices>(response, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/{symbol}/{year}/{month}")
    @ResponseBody
    public ResponseEntity<?> getPricesByMonth(@PathVariable("symbol") String symbol,
                                                         @PathVariable("year") int year,
                                                         @PathVariable("month") int month)
    {

        if (year < 1980 || year > 2015)
        {
            ErrorDetail error = new ErrorDetail();
            error.setTitle("year " + year);
            error.setErrorMessage("Validation failed");
            error.setDetail("year must be between 1980 and 2015");

            return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (month < 1 || month > 12)
        {
            ErrorDetail error = new ErrorDetail();
            error.setTitle("month " + month);
            error.setErrorMessage("Validation failed");
            error.setDetail("month must be between 1 and 12");

            return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        List<TickerPrice> prices = null;
        TickerPrices response = null;

        try
        {
            prices = dataService.getPricesByMonth(symbol,year,month);
            response = new TickerPrices();
            response.setPrices(prices);

        } catch (SQLException e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (!prices.isEmpty())
        {
            return new ResponseEntity<TickerPrices>(response, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/yearly/{symbol}")
    @ResponseBody
    public ResponseEntity<?> getYearlyPricesForSymbol(@PathVariable("symbol") String symbol)
    {
        List<YearlyPrice> prices = null;
        YearlyPrices response = null;

        try
        {
            prices = dataService.getYearlyPrices(symbol);
            response = new YearlyPrices();
            response.setPrices(prices);

        } catch (SQLException e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (!prices.isEmpty())
        {
            return new ResponseEntity<YearlyPrices>(response, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

}
