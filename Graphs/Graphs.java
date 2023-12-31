package Graphs;

import java.util.ArrayList;

public class Graphs
{
    public static class Edge
    {
        int v,w;
        Edge(int v,int w)
        {
            this.v=v;
            this.w=w;
        }
    }
    public static void addEdge(ArrayList<Edge> graph[],int u,int v,int w)
    {
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }
    public static void constructionOfGraph()
    {
        int V=7;
        ArrayList<Edge> graph[]=new ArrayList[V];
        for(int i=0;i<V;i++)
        {
            graph[i]=new ArrayList<>();
        }

        boolean vis[]=new boolean[V];
        addEdge(graph, 0,3,10);
        addEdge(graph, 0,1,10);
        // addEdge(graph, 1,0,10);
        addEdge(graph, 1,2,10);
        // addEdge(graph, 2,1,10);
        addEdge(graph, 2,3,40);
        // addEdge(graph, 2,7,2);
        // addEdge(graph, 2,8,4);
        // addEdge(graph, 3,0,10);
        addEdge(graph, 3,4,2);
        // addEdge(graph, 3,2,40);
        // addEdge(graph, 4,3,2);
        addEdge(graph, 4,5,2);
        addEdge(graph, 4,6,8);
        // addEdge(graph, 5,4,2);
        addEdge(graph, 5,6,3);
        // addEdge(graph, 6,5,3);
        // addEdge(graph, 6,4,8);
        // addEdge(graph, 7,8,3);
        // addEdge(graph, 7,2,2);
        // addEdge(graph, 8,7,3);
        // addEdge(graph, 8,2,4);
        display(graph, V);
        // boolean a=haspath(graph, 0, 6, vis);
        // System.out.println(a);
        // int b=countAllPath(graph, 0, 6, vis, "");
        // System.out.println(b);
        // Pair p=heavyPath(graph, 0, 6, vis);
        // System.out.println(p.heavyPathweight+","+p.psf);
         addEdge(graph, 0, 6, 3);
        ArrayList<String> ans=new ArrayList<>();
        hamiltonPathAndCycle(graph,0,0,0,"",ans,vis);
        System.out.println(ans);
        
    }
    
    //O(2E)==O(E)
    public static void display(ArrayList<Edge> graph[],int V)
    {
        for(int i=0;i<V;i++)
        {
            System.out.print(i+"-> ");
            for(Edge e:graph[i])
            {
                System.out.print("("+e.v+","+e.w+")");
            }
            System.out.println();
        }
    }
    public static int findIndexOfV(ArrayList<Edge> graph[],int u,int v)
    {
        for(int i=0;i<graph[u].size();i++)
        {
            for(Edge e:graph[i])
            {
                if(e.v==v){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void removeEdge(ArrayList<Edge> graph[],int u,int v)
    {
        int idx=findIndexOfV(graph, u, v);
        graph[u].remove(idx);

        int idx1=findIndexOfV(graph, v, u);
        graph[v].remove(idx1);
    }

    public static void removeVtx(ArrayList<Edge> graph[],int u,int v)
    {
        for(int i=graph[u].size()-1;i>=0;i--)
        {
            Edge e=graph[u].get(i);
            removeEdge(graph, u, e.v);
        }
    }

    public static boolean haspath(ArrayList<Edge> graph[],int src,int des,boolean vis[])
    {
        if(src==des)
        {
            return true;
        }
        boolean res=false;
        vis[src]=true;
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
            {
                res=res||haspath(graph, e.v, des, vis);
            }
        }

        return res;
    }

    public static int countAllPath(ArrayList<Edge> graph[],int src,int des,boolean vis[],String psf)
    {
        if(src==des)
        {
            System.out.println(psf+des);
            return 1;
        }
        int count=0;
        vis[src]=true;
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
            {
                count+=countAllPath(graph, e.v, des, vis,psf+src);
            }
        }
        vis[src]=false;
        return count;
    }

    public static void main(String[] args) {
        int V=7;
        boolean vis[]=new boolean[V];
        ArrayList<Edge> graph[]=new ArrayList[V];
        constructionOfGraph();
       
        
    }
    public static class Pair
    {
        int heavyPathweight;
        String psf;
        Pair()
        {

        }
        Pair(int heavyPathweight,String psf)
        {
            this.heavyPathweight=heavyPathweight;
            this.psf=psf;
        }
    }
    public static Pair heavyPath(ArrayList<Edge> graph[],int src,int des,boolean vis[])
    {
        if(src==des)
        {
            return new Pair(0,src+"");
        }
        Pair ans=new Pair(-1,"");
        vis[src]=true;
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
            {
                Pair recAns=heavyPath(graph, e.v, des, vis);
                if(recAns.heavyPathweight!=-1 && recAns.heavyPathweight+e.w>ans.heavyPathweight)
                {
                    ans.heavyPathweight=recAns.heavyPathweight+e.w;
                    ans.psf=src+recAns.psf;
                }
            }
            
        }
        vis[src]=false;
        return ans;
    }


    // public static Pair LightestPath(ArrayList<Edge> graph[],int src,int des,boolean vis[])
    // {
    //     if(src==des)
    //     {
    //         return new Pair(0,src+"");
    //     }
    //     Pair ans=new Pair(10^9,"");
    //     vis[src]=true;
    //     for(Edge e:graph[src])
    //     {
    //         if(!vis[e.v])
    //         {
    //             Pair recAns=heavyPath(graph, e.v, des, vis);
    //             if(recAns.heavyPathweight!=-1 && recAns.heavyPathweight+e.w<ans.heavyPathweight)
    //             {
    //                 ans.heavyPathweight=recAns.heavyPathweight+e.w;
    //                 ans.psf=src+recAns.psf;
    //             }
    //         }
            
    //     }
    //     vis[src]=false;
    //     return ans;
    // }

    public static void hamiltonPathAndCycle(ArrayList<Edge> graph[],int src,int osrc,int edgeCount,String psf,ArrayList<String> ans,boolean vis[])
    {
        if(edgeCount==graph.length-1)
        {
            psf+=src;
            int idx=findIndexOfV(graph, osrc, src);
            if(idx!=-1)
                psf+="*";

            ans.add(psf);
            return;
        }
        vis[src]=true;
        for(Edge e:graph[src])
        {
            if(!vis[e.v])
            {
                hamiltonPathAndCycle(graph, e.v, osrc, edgeCount+1, psf+src, ans, vis);
            }
        }
        vis[src]=false;
    }
    

}