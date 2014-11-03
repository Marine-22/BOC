package sk.posta.boc.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JacksonUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(JacksonUtil.class.getName());
	
	private static ObjectMapper mapper;
	
	private static ObjectMapper getObjectMapper(){
		if(JacksonUtil.mapper == null){
			return new ObjectMapper();
		}
		return mapper;
	}
	
	public static String object2Json(Object o){
		ObjectMapper mapper = JacksonUtil.getObjectMapper();
		String retVal = null;
		try{
			retVal = mapper.writeValueAsString(o);
		}catch(JsonMappingException e){
			logger.info("Exception: JsonMappingException");
		}catch(JsonGenerationException e){
			logger.info("Exception: JsonGenerationException");
		}catch(IOException e){
			logger.info("Exception: IOException");
		}
		return retVal;
	}
}
