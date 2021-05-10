package ru.geekbrains.algorithmjava.lesson7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MGraph {
    HashMap<String, Vertex> vertexLabelsDict;
    HashMap<String, ArrayList<String>> adjVertexMap;
    Queue<String> queue;

    public MGraph() {
        this.adjVertexMap = new HashMap<>();
        this.vertexLabelsDict = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public void addVertex(String label) {
        this.vertexLabelsDict.put(label, new Vertex(label));
        this.adjVertexMap.put(label, new ArrayList<>());
    }

    public void addEdge(String vertexFrom, String vertexTo) {
        if (!vertexLabelsDict.containsKey(vertexFrom)) {
            addVertex(vertexFrom);
        }
        if (!vertexLabelsDict.containsKey(vertexTo)) {
            addVertex(vertexTo);
        }
        this.adjVertexMap.get(vertexFrom).add(vertexTo);
    }

    public void showVertex(String vertex) {
        if (this.vertexLabelsDict.containsKey(vertex)) {
            System.out.print("'" + vertex + "' ");
        } else {
            System.out.println("No such vertex");
        }
    }

    public void showEdge(String vertex1, String vertex2) {
        if (this.vertexLabelsDict.containsKey(vertex1) && this.vertexLabelsDict.containsKey(vertex2)) {
            System.out.print("'" + vertex1 + "' -> '" + vertex2 + "' ");
        } else {
            System.out.println("No such vertex");
        }
    }

    public void dfs(String start) {
        if (!this.vertexLabelsDict.containsKey(start)) {
            return;
        }

        this.vertexLabelsDict.get(start).alreadyCovered = true;

        for (String adjVer : this.adjVertexMap.get(start)) {
            if (!this.vertexLabelsDict.get(adjVer).alreadyCovered) {
                showEdge(start, adjVer);
                dfs(adjVer);
            }
        }
    }

    public void dfsFull(String start) {
        dfs(start);
        System.out.println();
        eraseCoverage();
    }

    private void eraseCoverage() {
        for (Vertex vert : this.vertexLabelsDict.values()) {
            vert.alreadyCovered = false;
        }
    }

    public void bfs(String start) {
        this.vertexLabelsDict.get(start).alreadyCovered = true;

        for (String adjVer : this.adjVertexMap.get(start)) {
            if (!this.vertexLabelsDict.get(adjVer).alreadyCovered) {
                queue.add(adjVer);
            }
        }
        for (String adjVer : this.adjVertexMap.get(start)) {
            if (!this.vertexLabelsDict.get(adjVer).alreadyCovered) {
                bfs(adjVer);
            }
        }
    }

    public void bfsFull(String start) {
        showVertex(start);
        bfs(start);
        while (!this.queue.isEmpty()) {
            showVertex(queue.peek());
            queue.poll();
        }
        eraseCoverage();
        System.out.println();
    }


}
