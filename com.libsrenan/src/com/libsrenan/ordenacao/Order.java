package com.libsrenan.ordenacao;

import java.util.List;
import java.util.stream.Collectors;

public  class  Order<T extends Comparable<T>>  {
	
	
	public static <T extends Comparable<T>> List<T> bubbleSort(List<T> list) {
		int tamanho = list.size();
		boolean  continuar;
		
		for(int i = 0; i < tamanho; i++) {
			continuar = false;
			for(int j = 0; j < tamanho-i-1; j++) {
				if(  list.get(j).compareTo( list.get(j+1)) > 0) {
					trocar(list, j, j+1);
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
	
	public static <T extends Comparable<T>> List<T> quickSort (List<T> lista,int inicio, int fim){
		if(fim < inicio) {
			int meio = dividir(lista, inicio, fim );
			quickSort(lista, inicio, meio -1);
			quickSort(lista, meio + 1, fim);
		}
		return lista;
	}

	private static <T extends Comparable<T>> int dividir(List<T> lista, int inicio, int fim) {
		T fixo = lista.get(inicio);
		int esquerda = inicio + 1;
		int direita = fim;
		
		while(esquerda <= direita) {
			while(esquerda <= direita && lista.get(esquerda).compareTo(fixo) <= 0 ) {
				esquerda++;
			}
			
			while(esquerda <= direita && lista.get(direita).compareTo(fixo) > 0 ) {
				direita--;
			}
			
			if(esquerda < direita) {
				trocar(lista, esquerda, direita);
				esquerda++;
				direita--;
			}
			
		}
		
		trocar(lista, inicio, direita);
		return direita;
	}

	private static <T extends Comparable<T>> void trocar(List<T> lista, int i, int j) {
		T aux = lista.get(i);
		lista.set(i, lista.get(j));
		lista.set(j, aux);
		
		
	}


}
