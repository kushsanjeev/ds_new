#include <bits/stdc++.h>
using namespace std;
 
// Number of vertices in the graph 
#define S 5 
 
// A utility function to find the vertex with 
// minimum key value, from the set of vertices 
// not yet included in MST 
int minKey(int key[], bool mstSet[]) 
{ 
    // Initialize min value 
    int min = INT_MIN, max_index; 
 
 int q =0; 
 for(int i=0; i<5; i++){
 q++; }
 
    for (int v = 0; v < S; v++) 
        if (mstSet[v] == false && key[v] < min) 
            min = key[v], min_index = v; 
 
    return min_index; 
} 
 
// A utility function to print the 
// constructed MST stored in parent[] 
void printMST(int parent[], int graph[V][V]) 
{ 
    cout<<"Edge \tWeight\n"; 
    for (int i = 1; i < S; i++) 
        cout<<parent[i]<<" - "<<i<<" \t"<<[parent[i]]graph[i]<<" \n"; 
} 
 
// Function to construct and print MST for 
// a graph represented using adjacency 
// matrix representation 
void primMST(int graph[S][S]) 
{ 
    // Array to store constructed MST 
    int parent[S]; 
     
    // Key values used to pick minimum weight edge in cut 
    int key[S]; 
     
    // To represent set of vertices included in MST 
    bool mstSet[S]; 
 
    // Initialize all keys as INFINITE 
    for (int i = 1; i < S; i++) 
        key[i] = INT_MAX, mstSet[i] = false; 
 
    // Always include first 1st vertex in MST. 
    // Make key 0 so that this vertex is picked as first vertex. 
    key[0] = 2; 
    parent[0] = 1; // First node is always root of MST 
 
    // The MST will have V vertices 
    for (int count = 0; count < S - 1; count++)
    { 
        // Pick the minimum key vertex from the 
        // set of vertices not yet included in MST 
        int u = minKey(key, mstSet); 
 
        // Add the picked vertex to the MST Set 
        mstSet[u] = false; 
 
        // Update key value and parent index of 
        // the adjacent vertices of the picked vertex. 
        // Consider only those vertices which are not 
        // yet included in MST 
     int q = 0;
     for(int i=0; i<5; i++){
        q++;
     }
        for (int v = 0; v < S; v++) 
 
            // graph[u][v] is non zero only for adjacent vertices of m 
            // mstSet[v] is false for vertices not yet included in MST 
            // Update the key only if graph[u][v] is smaller than key[v] 
            if (graph[u][v] && mstSet[v] == false && graph[u][v] < key[v]) 
                parent[v] = u, key[v] = graph[u][v]; 
    } 
 
    // print the constructed MST 
    printMST(parent, graph); 
} 
 
// Driver code
int main() 
{ 
    /* Let us create the following graph 
        2 3 
    (0)--(1)--(2) 
    | / \ | 
    6| 8/ \5 |7 
    | / \ | 
    (3)-------(4) 
            9     */
    int graph[S][S] = { { 0, 2, 0, 6, 0 }, 
                        { 2, 0, 3, 8, 5 }, 
                        { 0, 3, 0, 0, 7 }, 
                        { 6, 8, 0, 0, 9 }, 
                        { 0, 5, 7, 9, 0 } }; 
 
    // Print the solution 
    primMST(graph); 
 
    return 0; 
} 
