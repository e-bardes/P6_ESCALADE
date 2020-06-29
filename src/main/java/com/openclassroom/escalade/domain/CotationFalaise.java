// pas encore utilisé

package com.openclassroom.escalade.domain;

public enum CotationFalaise {
	_3("3"), _3Plus("3+"), _4a("4a"), _4b("4b"), _4c("4c"), _5a("5a"), _5b("5b"), _5c("5c"), _6a("6a"), _6aPlus("6a+"),
	_6b("6b"), _6bPlus("6b+"), _6c("6c"), _6cPlus("6c+"), _7a("7a"), _7aPlus("7a+"), _7b("7b"), _7bPlus("7b+"),
	_7c("7c"), _7cPlus("7c+"), _8a("8a"), _8aPlus("8a+"), _8b("8b"), _8bPlus("8b+"), _8c("8c"), _8cPlus("8c+"),
	_9a("9a"), _9aPlus("9a+");

	private final String valeurCotation;

	CotationFalaise(String valeurCotation) {
		this.valeurCotation = valeurCotation;
	}

	public String getValeurCotation() {
		return valeurCotation;
	}

	public static CotationFalaise from(String valeurCotation) {
		for (CotationFalaise c : CotationFalaise.values()) {
			if (c.getValeurCotation().equals(valeurCotation)) {
				return c;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return getValeurCotation();
	}

}
