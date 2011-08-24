/* Copyright 2011 Ebay Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 *    
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.a11ytesting.test.wcag;

import static org.a11ytesting.test.Shared.LANG;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.a11ytesting.filter.HtmlFilter;
import org.a11ytesting.test.Filter;
import org.a11ytesting.test.Issue;
import org.a11ytesting.test.Issue.Severity;
import org.jsoup.nodes.Element;

public class HtmlHasValidLanguageCode extends AbstractUnderstandableRule {

	@Override
	public String getRuleName() {
		return "checkHtmlHasValidLanguageCode";
	}

	@Override
	public Filter getFilter() {
		return new HtmlFilter();
	}

	/**
	 * Check that every html page has a valid lang element
	 * 
	 * @see http://openajax-dev.jongund.webfactional.com/wcag20/rule/35/
	 * @see http://download.oracle.com/javase/1.4.2/docs/api/java/util/Locale.html#getISOLanguages
	 * 
	 * @param html
	 * @return issue or null
	 */
	@Override
	public Issue check(Element html) {
		List<String> codes = Arrays.asList(Locale.getISOLanguages());
		if (!html.hasAttr(LANG) || !codes.contains(
				html.attr(LANG).toLowerCase())) {
			return new Issue("checkHtmlHasValidLanguageCode",
					"Check that html element has a valid language code",
					Severity.ERROR, html);
		}
		return null;
	}

}
