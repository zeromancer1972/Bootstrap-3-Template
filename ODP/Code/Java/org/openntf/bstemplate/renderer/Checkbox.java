package org.openntf.bstemplate.renderer;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

public class Checkbox extends Renderer {

	@Override
	public void encodeBegin(final FacesContext context, final UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("input", null);
		writer.writeAttribute("id", component.getClientId(context), null);
		writer.writeAttribute("name", component.getClientId(context), null);
		writer.writeAttribute("type", "checkbox", null);
	}

	@Override
	public void encodeEnd(final FacesContext context, final UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.endElement("input");
	}

	@Override
	public void encodeChildren(final FacesContext context, final UIComponent component) throws IOException {
		super.encodeChildren(context, component);
	}

}
