package org.openntf.bstemplate.renderer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import com.ibm.xsp.complex.Attr;

public class Alert extends Renderer {

	@SuppressWarnings("unchecked")
	@Override
	public void encodeBegin(final FacesContext context, final UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		// DIV
		writer.startElement("div", null);
		writer.writeAttribute("id", component.getClientId(context), null);
		String alertType = "info";
		if (component.getAttributes().get("role") != null) {
			alertType = (String) component.getAttributes().get("role");
		}
		writer.writeAttribute("class", "alert alert-" + alertType + " alert-dismissible", null);
		writer.writeAttribute("role", "alert", null);

		// Closable?
		List attrs = (ArrayList) component.getAttributes().get("attrs");
		if (attrs != null) {
			if (!getAttributeVal("closable", attrs).equals("")) {
				// BUTTON
				writer.startElement("button", null);
				writer.writeAttribute("type", "button", null);
				writer.writeAttribute("class", "close", null);
				writer.writeAttribute("data-dismiss", "alert", null);
				String closeLabel = "Close";
				if (component.getAttributes().get("title") != null) {
					closeLabel = (String) component.getAttributes().get("title");
				}
				writer.writeAttribute("aria-label", closeLabel, null);
				// X
				writer.startElement("span", null);
				writer.writeAttribute("aria-hidden", "true", null);
				writer.writeText("X", null);
				writer.endElement("span");
				writer.endElement("button");
			}
		}
	}

	@SuppressWarnings("unchecked")
	private String getAttributeVal(final String key, final List attrs) {
		String val = "";
		for (int x = 0; x < attrs.size(); x++) {
			Attr att = (Attr) attrs.get(x);
			if (att.getName().equals(key)) {
				val = att.getValue().toString();
			}
		}
		return val;
	}

	@Override
	public void encodeChildren(final FacesContext context, final UIComponent component) throws IOException {
		super.encodeChildren(context, component);
	}

	@Override
	public void encodeEnd(final FacesContext context, final UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.endElement("div");
	}

}
