package org.credo.javaee.jaxb;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.credo.javaee.jaxb.model.Userinfo;

/**
 * JAXB 导出Schema。
 * 
 * @author: Credo
 * @date: 2013-6-25
 */
public class JAXBExportSchema {

	public static void main(String[] args) {

		JAXBContext jct;
		try
		{
			jct = JAXBContext.newInstance(Userinfo.class);
			jct.generateSchema(new Resolver());
		}
		catch ( Exception ex )
		{
			ex.printStackTrace();
		}
	}
}

class Resolver extends SchemaOutputResolver {

	@Override
	public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {

		File file = new File("d:\\", suggestedFileName);
		StreamResult result = new StreamResult(file);
		result.setSystemId(file.toURI().toURL().toString());
		return result;
	}

}
