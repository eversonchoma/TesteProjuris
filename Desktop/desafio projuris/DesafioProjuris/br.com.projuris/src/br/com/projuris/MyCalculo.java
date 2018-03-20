package br.com.projuris;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class MyCalculo implements Calculo {
	
	public List<Funcionario> GetListaFuncionario()
	{
		
		Funcionario funcionario1 = new Funcionario("Assistente", "Administrativo", new BigDecimal(1000.0));
		Funcionario funcionario2 = new Funcionario("Gerente", "Administrativo", new BigDecimal(7000.70));
		Funcionario funcionario3 = new Funcionario("Diretor", "Administrativo", new BigDecimal(10000.45));
		Funcionario funcionario4 = new Funcionario("Assistente", "Financeiro", new BigDecimal(1300.9));
		Funcionario funcionario5 = new Funcionario("Gerente", "Financeiro", new BigDecimal(7500));
		Funcionario funcionario6 = new Funcionario("Diretor", "Financeiro", new BigDecimal(11000.0));
		Funcionario funcionario7 = new Funcionario("Estagiário", "Jurídico", new BigDecimal(700.4));
		Funcionario funcionario8 = new Funcionario("Assistente", "Jurídico", new BigDecimal(1800.90));
		Funcionario funcionario9 = new Funcionario("Gerente", "Jurídico", new BigDecimal(9500.50));
		Funcionario funcionario10 = new Funcionario("Diretor", "Jurídico", new BigDecimal(13000.0));
		
		List<Funcionario> listaFuncionario = new ArrayList<>();
		listaFuncionario.add(funcionario1);
		listaFuncionario.add(funcionario2);
		listaFuncionario.add(funcionario3);
		listaFuncionario.add(funcionario4);
		listaFuncionario.add(funcionario5);
		listaFuncionario.add(funcionario6);
		listaFuncionario.add(funcionario7);
		listaFuncionario.add(funcionario8);
		listaFuncionario.add(funcionario9);
		listaFuncionario.add(funcionario10);
		
		return listaFuncionario;
	}

	@Override
	public List<CustoCargo> custoPorCargo(List<Funcionario> funcionarios) {

		List<CustoCargo> listaCustoCargoAux = new ArrayList<CustoCargo>();
		List<CustoCargo> listaCustoCargo = new ArrayList<CustoCargo>();
		CustoCargo custoCargo;
		
		for (int i = 0; i < funcionarios.size(); i++) {
			custoCargo = new CustoCargo();
			custoCargo.setCargo(funcionarios.get(i).getCargo());
			custoCargo.setCusto(funcionarios.get(i).getSalario());
			
			listaCustoCargoAux.add(custoCargo);
		}

		Map<String, BigDecimal> listaMap = new HashMap<String, BigDecimal>();
		BigDecimal totalAtual = null;
		for (CustoCargo item : listaCustoCargoAux) {
		    if (listaMap.containsKey(item.getCargo())) {
		    	for (Map.Entry<String, BigDecimal> itemInterno : listaMap.entrySet()) {
					if (itemInterno.getKey() == item.getCargo()) {
						totalAtual = itemInterno.getValue().add(item.getCusto());
					}
				}
		    	listaMap.put(item.getCargo(), totalAtual);
		    } else {
		    	listaMap.put(item.getCargo(), item.getCusto());
		    }
		}
		
		for (Map.Entry<String, BigDecimal> item : listaMap.entrySet()) {
		    custoCargo = new CustoCargo();
			custoCargo.setCargo(item.getKey());
			custoCargo.setCusto(item.getValue());
			
			listaCustoCargo.add(custoCargo);
		}

		return listaCustoCargo;
	}
	

	@Override
	public List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios) {

		List<CustoDepartamento> listaCustoDepartamentoAux = new ArrayList<CustoDepartamento>();
		List<CustoDepartamento> listaCustoDepartamento = new ArrayList<CustoDepartamento>();
		CustoDepartamento custoDepartamento;
		
		for (int i = 0; i < funcionarios.size(); i++) {
			custoDepartamento = new CustoDepartamento();
			custoDepartamento.setDepartamento(funcionarios.get(i).getDepartamento());
			custoDepartamento.setCusto(funcionarios.get(i).getSalario());
			
			listaCustoDepartamentoAux.add(custoDepartamento);
		}

		Map<String, BigDecimal> listaMap = new HashMap<String, BigDecimal>();
		BigDecimal totalAtual = null;
		for (CustoDepartamento item : listaCustoDepartamentoAux) {
		    if (listaMap.containsKey(item.getDepartamento())) {
		    	for (Map.Entry<String, BigDecimal> itemInterno : listaMap.entrySet()) {
					if (itemInterno.getKey() == item.getDepartamento()) {
						totalAtual = itemInterno.getValue().add(item.getCusto());
					}
				}
		    	listaMap.put(item.getDepartamento(), totalAtual);
		    } else {
		    	listaMap.put(item.getDepartamento(), item.getCusto());
		    }
		}
		
		for (Map.Entry<String, BigDecimal> item : listaMap.entrySet()) {
		    custoDepartamento = new CustoDepartamento();
			custoDepartamento.setDepartamento(item.getKey());
			custoDepartamento.setCusto(item.getValue());
			
			listaCustoDepartamento.add(custoDepartamento);
		}

		return listaCustoDepartamento;
	}

}
