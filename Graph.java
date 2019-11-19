import java.util.*;

public class Graph
{
	private int[][] matrix;
	private int vertices;

	public Graph(int vertices)
	{
		this.vertices = vertices;
		matrix = new int[vertices][vertices];
	}

	public void addEdge(int v1, int v2)
	{
		//System.out.println(v1+" "+v2);
		matrix[v1][v2] = 1;
	}

	public void addAllEdges(int [][] trust)
	{
		for (int i=0; i < trust.length; i++)
		{
			//System.out.println(trust[i][0]+" "+trust[i][1]);
			addEdge((trust[i][0]-1), (trust[i][1]-1));
		}
	}

	public int findTrust()
	{
		int [] sum = new int[vertices];
		int count=0;
		int judge=-1;

		for (int i=0; i < vertices; i++)
		{
			for (int j=0; j < vertices; j++)
				sum[i]+=matrix[j][i];
		}

		for (int i=0; i < vertices; i++)
		{
			if (sum[i]==(vertices-1))
			{
				count++;
				judge = i;
			}
		}

		if (count==1)
		{
			for (int i=0; i< vertices; i++)
			{
				if (matrix[judge][i]>0)
					return -1;
			}
			
			return (judge+1);
		}
		else
			return -1;
	}
}