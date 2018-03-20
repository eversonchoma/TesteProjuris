package br.com.projuris;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		MyCalculo myCalculo = new MyCalculo();
		List<Funcionario> listaFuncionario = myCalculo.GetListaFuncionario();
		
		List<CustoCargo> listaCustoCargo = myCalculo.custoPorCargo(listaFuncionario);
		
		List<CustoDepartamento> listaCustoDepartamento = myCalculo.custoPorDepartamento(listaFuncionario);
	}
}
