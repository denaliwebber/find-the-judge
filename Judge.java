public class Judge
{
	public int findJudge (int N, int [][] trust)
	{
		Graph g = new Graph(N);
		g.addAllEdges(trust);
		return g.findTrust();
	}
}