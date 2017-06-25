package cn.itheima.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date parse = format.parse(source);
			return parse;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
