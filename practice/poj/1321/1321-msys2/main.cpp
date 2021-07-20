#include <iostream>

using namespace std;

int i = 0;
int j = 0;
int amount = 0;
int edge_limit = 0;
int chess_limit = 0;
char chessboard[8][8];
int chess_row_placed[8] = {0};

void dfs(int i);
int main(){
    cin >> edge_limit >> chess_limit;

    while(edge_limit!=-1||chess_limit!=-1){
        // read data
        for(i = 0; i < edge_limit; i++){
            for(j = 0; j < edge_limit; j++){
                cin >> chessboard[i][j];
            }
        }

        // 
        for(i = 0; i < edge_limit - chess_limit; i++){
            dfs(i);
        }

        cout << amount << endl;
    }
    return 0;
}

int canPut(int row);
void dfs(int i){

    for(j = 0; j < edge_limit; j++){
        if(chessboard[i][j]== '#' && canPut(j)) {
            i++;
            if(i<edge_limit){
                chess_row_placed[i] = 1;
                dfs(i);
                }
            else amount++;
        }
    }

}

int canPut(int row){
    if(chess_row_placed[row] == 0) return 1;
    else return 0;
}
