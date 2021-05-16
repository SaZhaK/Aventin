@XmlSchema(
		namespace = "http://webmaster.yandex.ru/schemas/feed/realty/2010-06",
		elementFormDefault = XmlNsForm.QUALIFIED,
		xmlns = {
				@XmlNs(prefix="ns1", namespaceURI="http://webmaster.yandex.ru/schemas/feed/realty/2010-06")
		}
)
package application.domain.parse.xml;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;