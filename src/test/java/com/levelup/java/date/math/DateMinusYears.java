package com.levelup.java.date.math;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * This java example will demonstrate subtracting years from a date
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/subtract-years-from-date/'>Subtract years from date</a>
 * 
 */
public class DateMinusYears {
	
	private static final Logger logger = Logger.getLogger(DateMinusYears.class);

	@Test
	public void subtract_years_from_date_in_java () {
		
		Calendar superBowlXLV = Calendar.getInstance();
		superBowlXLV.set(2011, 1, 6, 0, 0);
		
		Calendar numberFour = Calendar.getInstance();
		numberFour.setTimeInMillis(superBowlXLV.getTimeInMillis());
		numberFour.add(Calendar.YEAR, -14);		
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(superBowlXLV.getTime()));
		logger.info(dateFormatter.format(numberFour.getTime()));

		assertTrue(numberFour.before(superBowlXLV));
	}

	@Test
	public void subtract_years_from_date_in_java8() {

		LocalDateTime newYearsDay = LocalDateTime.of(2011, Month.FEBRUARY, 6,
				0, 0);
		LocalDateTime numberFour = newYearsDay.minusYears(14);

		java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter
				.ofPattern("MM/dd/yyyy HH:mm:ss S");

		logger.info(newYearsDay.format(formatter));
		logger.info(numberFour.format(formatter));

		assertTrue(numberFour.isBefore(newYearsDay));
	}
	
	@Test
	public void subtract_years_from_date_in_java_joda () {

		DateTime superBowlXLV = new DateTime(2011, 2, 6, 0, 0, 0, 0);
		DateTime numberFour = superBowlXLV.minusYears(14);

		DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss z");
		
		logger.info(superBowlXLV.toString(fmt));
		logger.info(numberFour.toString(fmt));

		assertTrue(numberFour.isBefore(superBowlXLV));
	}

	
	@Test
	public void subtract_years_from_date_in_java_apachecommons () {
		
		Calendar superBowlXLV = Calendar.getInstance();
		superBowlXLV.set(2011, 1, 6, 0, 0);
		
		Date numberFour = DateUtils.addYears(superBowlXLV.getTime(), -14);
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(superBowlXLV.getTime()));
		logger.info(dateFormatter.format(numberFour));

		assertTrue(numberFour.before(superBowlXLV.getTime()));		
	}

	
}
