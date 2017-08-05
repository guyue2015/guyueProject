package com.guyue.commonweb.config;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ConfigParam {
	@Value("${guyue.record.time.method.package:com.guyue.commonweb.empty.*}")
	private String recordPackagePath;
}
