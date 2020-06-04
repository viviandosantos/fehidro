package fehidro.model;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import fehidro.control.ItemRelatorio;


public class Relatorio  {
	
	protected HashMap<Long, ItemRelatorio> itensRelatorio;
	protected HashMap<Long, Integer> classificacao; //TODO: Hashmap eh a melhor forma de implementar isso?
	
	//Construtores
	public Relatorio()
	{
		itensRelatorio = new HashMap<Long, ItemRelatorio>();
	}
	
	public Relatorio(List<Avaliacao> avaliacoes)
	{
		setItensRelatorio(avaliacoes);
	}
	
	//Metodos
	
	public void calcularClassificacao()
	{
		//TODO: IMPLEMENTAR
//		for(int i =0;i<itensRelatorio.size();i++)
//		{
//			classificacao
//		}
	}
	
	public void setItensRelatorio(List<Avaliacao> avaliacoes)
	{
		Avaliacao avaliacaoAtual;
		Long idPropostaAtual;
		for(int i =0;i<avaliacoes.size();i++)
		{
			avaliacaoAtual = avaliacoes.get(i);
			idPropostaAtual = avaliacaoAtual.getProposta().getId();
			System.out.println("> id proposta atual = "+idPropostaAtual.toString());
			if(this.itensRelatorio.get(idPropostaAtual) == null)
			{
				this.itensRelatorio.put(idPropostaAtual, new ItemRelatorio() );
			}
			
			System.out.println("TEST1 - "+idPropostaAtual);
			System.out.println("TEST2 - "+avaliacaoAtual.toString());
			
			this.itensRelatorio.get(idPropostaAtual).addAvaliacao(avaliacaoAtual);
		}
	}
	
	public LinkedList<ItemRelatorio> getItensRelatorio()
	{
		System.out.println("getting itens relatorio");
		return new LinkedList<ItemRelatorio>(this.itensRelatorio.values());
	}
	
	
}
