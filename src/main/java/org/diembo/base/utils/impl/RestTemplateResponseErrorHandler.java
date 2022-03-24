package org.diembo.base.utils.impl;

import java.io.IOException;

import org.diembo.base.utils.SaphirHttpException;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.UnknownHttpStatusCodeException;

@Component
@Primary
public class RestTemplateResponseErrorHandler extends DefaultResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		try {
			if (isSpecificHttpErrorCode(response.getRawStatusCode())) {
				return true;
			}
			return super.hasError(response);
			
		} catch (UnknownHttpStatusCodeException ex) {
			return false;
		}
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		if (isSpecificHttpErrorCode(response.getRawStatusCode())) {
			throw new SaphirHttpException(response.getRawStatusCode(), null);
		}
		super.handleError(response);
	}

	protected boolean isSpecificHttpErrorCode(int rawStatusCode) {
		return false;
	}

}