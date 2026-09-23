class Solution {
    public int numIslands(char[][] grid) {
        int a=grid.length;
        int b=grid[0].length;
        int cout=0;
        for(int i=0;i<a;i++)
        {
            for(int j=0;j<b;j++)
            {
                if(grid[i][j]=='1')
                {
                    cout++;
                    dfs(grid,i,j,a,b);
                }
            }
        }
        return cout;
    }
    void dfs(char [][] arr,int i,int j,int a,int b)
    {
        if(i>=a || j>=b || i<0 || j<0 || arr[i][j]=='0'){
            return;
        }
        arr[i][j] = '0';
        dfs(arr,i+1,j,a,b);
        dfs(arr,i-1,j,a,b);
        dfs(arr,i,j+1,a,b);
        dfs(arr,i,j-1,a,b);
    }
}