package l6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Animal {
	private String raca;
	private String genero;
	public String idade;
	
	

	public Animal(String raca, String genero, String idade) {
		this.raca = raca;
		this.genero = genero;
		this.idade = idade;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public static void rankRaca(ArrayList<Animal> animais) {
		for(Animal animal: animais) {
			System.out.println(animal.getRaca());
			System.out.println(animal.getGenero());
		}
	}
	
	public static void ranks(ArrayList<Animal> animais, String escolha) {
		List<String> racas = new ArrayList<String>();
		List<ContadorRacas> racasDiferentes = new ArrayList<ContadorRacas>();
		int femea = 0;
		int masc = 0;
	
		if(escolha.equals("1")) {
			for(Animal animal: animais) {
				racas.add(animal.getRaca());
			}
			Collections.sort(racas);
			
			String racaAnterior = null;
			for(String raca : racas) {
				if(!raca.equals(racaAnterior)) {
					racaAnterior = raca;
					ContadorRacas racaNova = new ContadorRacas(raca);
					racasDiferentes.add(racaNova);
				} else {
					for(ContadorRacas racaDiferente: racasDiferentes) {
						if(racaDiferente.getRaca().equals(raca)) {
							racaDiferente.setQuantidade();
						}
					}
				}
			}
			
			Collections.sort(racasDiferentes);
			System.out.println("Rank de Ra�as");
			int cont = 1;
			for(ContadorRacas racaDiferente: racasDiferentes) {
				System.out.println(cont + "�- " + racaDiferente.getRaca() + " com " + racaDiferente.getQuantidade() + " exemplares");
				cont += 1;
			}
			
			
			
			
			
		}else if(escolha.equals("2")) {
			for(Animal animal: animais) {
				if(animal.genero.equals("f")) {
					femea += 1;
				}else {
					masc += 1;
				}
			}
			if(femea > masc) {
				System.out.println("A prefer�ncia de g�nero dos animais � f�mea"+
						"\nF�meas: "+ femea+
						"\nMachos: "+ masc);
			}else if(femea<masc) {
				System.out.println("A prefer�ncia de g�nero de animais � macho"+
						"\nF�meas: "+ femea+
						"\nMachos: "+ masc);
			}else{
				System.out.println("N�o h� prefer�ncia de g�nero de animais");
			}
		}else {
			System.out.println("Op��o Inv�lida");
		}
		
	}
	
	
	
}
