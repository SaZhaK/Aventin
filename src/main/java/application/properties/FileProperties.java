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

	/**
	 * Корневая директория.
	 */
	private final String rootDirectory;

	public FileProperties(@DefaultValue(DEFAULT_ROOT_DIRECTORY) String rootDirectory) {
		this.rootDirectory = rootDirectory;
	}
}