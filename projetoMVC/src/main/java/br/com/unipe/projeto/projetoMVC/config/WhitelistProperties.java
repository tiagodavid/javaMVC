package br.com.unipe.projeto.projetoMVC.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:whitelist.properties")
public class WhitelistProperties {
	@Value("${allowed_origins")
	private String[] allowed_origins;

	public String[] getAllowed_origins() {
		return allowed_origins;
	}

	public void setAllowed_origins(String[] allowed_origins) {
		this.allowed_origins = allowed_origins;
	}
	
	
}
