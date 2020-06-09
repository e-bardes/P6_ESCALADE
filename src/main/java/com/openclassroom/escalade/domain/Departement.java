package com.openclassroom.escalade.domain;

public enum Departement {

	alpes_de_haute_provence("Alpes-de-Haute-Provence"), alpes_maritimes("Alpes-Maritime"), ardeche("Ardèche"),
	ariege("Ariège"), aude("Aude"), auvergne("Auvergne"), aveyron("Aveyron"), bas_rhin("Bas-Rhin"),
	bouches_du_rhone("Bouches-du-Rhônes"), bourgogne("Bourgogne"), charente("Charente"), corse_du_sud("Corse-du-Sud"),
	cotes_darmor("Côtes-d'Armor"), doubs("Doubs"), drome("Drôme"), finistere("Finistère"), gard("Gard"),
	haut_rhin("Haut-Rhin"), haute_corse("Haute-Corse"), haute_marne("Haute-Marne"), haute_savoie("Haute-Savoie"),
	hautes_alpes("Haute-Alpes"), hautes_pyrenees("Haute-Pyrénées"), herault("Hérault"), isere("Isère"), jura("Jura"),
	loire_atlantique("Loire-Atlantique"), lot("Lot"), lozere("Lozère"), marne("Marne"), meuse("Meuse"),
	moselle("Moselle"), pyrenees_atlantique("Pyrénées-Atlantiques"), pyrenees_orientales("Pyrénées-Orientales"),
	savoie("Savoie"), seine_et_marne("Seine-et-Marne"), tarn_et_garonne("Tarn-et-Garonne"), var("Var"),
	vaucluse("Vaucluse"), yonne("Yonne"), yvelines("Yvelines");

	private final String valeurDepartement;

	Departement(String valeurDepartement) {
		this.valeurDepartement = valeurDepartement;
	}

	public String getValeurDepartement() {
		return valeurDepartement;
	}

	public static Departement from(String valeurDepartement) {
		for (Departement d : Departement.values()) {
			if (d.getValeurDepartement().equals(valeurDepartement)) {
				return d;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return getValeurDepartement();
	}
}
