// pas encore utilisé

package com.openclassroom.escalade.domain;

public enum CotationBloc {
	_4("4"), _4plus("4+"), _5("5"), _5plus("5+"), _6A("6A"), _6Aplus("6A+"), _6B("6B"), _6Bplus("6B+"), _6C("6C"),
	_6Cplus("6C+"), _7A("7A"), _7Aplus("7A+"), _7B("7B"), _7Bplus("7B+"), _7C("7C"), _7Cplus("7C+"), _8A("8A"),
	_8Aplus("8A+"), _8B("8B"), _8Bplus("8B+"), _8C("8C"), _8Clus("8C+");

	private final String valeurCotation;

	CotationBloc(String valeurCotation) {
		this.valeurCotation = valeurCotation;
	}

	public String getValeurCotation() {
		return valeurCotation;
	}

	public static CotationBloc from(String valeurCotation) {
		for (CotationBloc c : CotationBloc.values()) {
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
