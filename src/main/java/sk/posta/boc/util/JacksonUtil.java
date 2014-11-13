package sk.posta.boc.util;

import java.io.ByteArrayOutputStream;
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
			//ByteArrayOutputStream baos = new ByteArrayOutputStream();
			//mapper.writeValue(baos, o);
			//retVal = baos.toString("UTF-8");
			retVal = mapper.writeValueAsString(o);
			logger.info("Retval object2Json: " + retVal);
		}catch(JsonMappingException e){
			logger.info("Exception: at JacksonUtil JsonMappingException", e);
		}catch(JsonGenerationException e){
			logger.info("Exception: at JacksonUtil JsonGenerationException", e);
		}catch(IOException e){
			logger.info("Exception: at JacksonUtil IOException", e);
		}
		return retVal;
	}
}
