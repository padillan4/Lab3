
public class KnightsTour {
	
	public static Integer[][] startKnightsTour(int size, int currX, int currY){
		Integer[][] map = new Integer[size][size];
		map[currX][currY] = 1;
		boolean result = knightsTour(map,currX,currY,2,1);
		int attempt = 1;
		
		while(result == false && attempt < 8){
			result = knightsTour(map,currX,currY,2,attempt++);
		}
		return map;
			
	}

	private static boolean knightsTour(Integer[][] map, int currX, int currY, int turn, int attempt){
		if(attempt == 1){
			try{
				map[currX-2][currY+1] = turn;
			}
			catch(Exception e){
				return false;
			}
		}
		else if(attempt == 2){
			try{
				map[currX-2][currY-1] = turn;
			}
			catch(Exception e){
				return false;
			}
		}
		else if(attempt == 3){
			try{
				map[currX+2][currY+1] = turn;
			}
			catch(Exception e){
				return false;
			}
		}
		else if(attempt == 4){
			try{
				map[currX+2][currY-1] = turn;
			}
			catch(Exception e){
				return false;
			}
		}
		else if(attempt == 5){
			try{
				map[currX+1][currY-2] = turn;
			}
			catch(Exception e){
				return false;
			}
		}
		else if(attempt == 6){
			try{
				map[currX-1][currY-2] = turn;
			}
			catch(Exception e){
				return false;
			}
		}
		else if(attempt == 7){
			try{
				map[currX+1][currY+2] = turn;
			}
			catch(Exception e){
				return false;
			}
		}
		else if(attempt == 8){
			try{
				map[currX-1][currY+2] = turn;
			}
			catch(Exception e){
				return false;
			}
		}
		
		if (turn == map.length * map.length){
			return true;
		}
		else{
			boolean result = knightsTour(map,currX,currY,turn++,1);
			int tries = 1;
			
			while(result == false && tries < 8){
				result = knightsTour(map,currX,currY,2,tries++);
			}
			return false;
		}
	}
}
