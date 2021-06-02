package application.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "files.xml")
public class FileProperties {
	private static final String DEFAULT_ROOT_DIRECTORY = "src/main/resources/xml/data.xml";
	private static final String DEFAULT_CRM_URL = "https://ravenalara.wixsite.com/website-6/_functions/constructionSites";

	/**
	 * Корневая директория.
	 */
	private final String rootDirectory;

	/**
	 * Ссылка на CRM систему.
	 */
	private final String crmUrl;

	public FileProperties(@DefaultValue(DEFAULT_ROOT_DIRECTORY) String rootDirectory,
						  @DefaultValue(DEFAULT_CRM_URL) String crmUrl) {
		this.rootDirectory = rootDirectory;
		this.crmUrl = crmUrl;
	}
}