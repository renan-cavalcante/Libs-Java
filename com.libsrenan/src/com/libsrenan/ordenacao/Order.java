package com.libsrenan.ordenacao;

import java.util.List;
import java.util.stream.Collectors;

public  class  order<T> {
	
	
	public static <T extends Comparable<T>> List<T> bubbleSort(List<T> list) {
		int tamanho = list.size();
		boolean  continuar;
		
		for(int i = 0; i < tamanho; i++) {
			continuar = false;
			for(int j = 0; j < tamanho-i-1; j++) {
				if(  list.get(j).compareTo( list.get(j+1)) > 0) {
					T aux = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, aux);
					continuar = true;
				}
			}
			if(!continuar) break;
		}
		return list;
	}
	
	public static  <T extends Comparable<T>> List<T> mergeSort(List<T> lista, int inicio, int fim){
		if(inicio < fim) {
			int meio = (inicio + fim) / 2;
			
			mergeSort(lista, inicio, meio);
			mergeSort(lista, meio + 1, fim);
			interar(lista, inicio, meio, fim );
		}
		return lista;
	}

	private static <T extends Comparable<T>> void interar(List<T> lista, int inicio, int meio, int fim) {
		List<T> listaAux = lista.stream().collect(Collectors.toList());
		
		 int esquerda = inicio;
		 int direita = meio + 1;
		 
		 for(int i = inicio; i <= fim; i++) {
			 if(esquerda > meio) {
				 	lista.set(i, listaAux.get(direita));
					direita++;
				}else if(direita > fim) {
					lista.set(i, listaAux.get(esquerda));
					esquerda++;
				}else if(listaAux.get(esquerda).compareTo(listaAux.get(direita)) > 0) {
					lista.set(i, listaAux.get(direita));
					direita++;
				}else {
					lista.set(i, listaAux.get(esquerda));
					esquerda++;
				}
		 }
		
	}

}
