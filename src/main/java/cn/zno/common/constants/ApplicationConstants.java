package cn.zno.common.constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConstants {


	public static String SWAGGER_PATH;

	@Autowired(required = true)
	public void setSWAGGER_PATH(@Value("#{config['swagger.path']}") String SWAGGER_PATH) {
		ApplicationConstants.SWAGGER_PATH = SWAGGER_PATH;
	}
}
