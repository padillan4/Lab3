public class KnightsTour {
	
	public static Integer[][] startKnightsTour(int size, int currX, int currY){
		Integer[][] map = new Integer[size][size];
		map[currX][currY] = 1;
		boolean result = knightsTour(map,currX,currY,2,1);
		int attempt = 1;
		
		while(result == false && attempt < 8){
			result = knightsTour(map,currX,currY,2,attempt++);
		}
		//if (result == false){
		//	return null;
		//}
		return map;
			
	}

	private static boolean knightsTour(Integer[][] map, int currX, int currY, int turn, int attempt){
		int x = 0;
		int y = 0;
		if(attempt == 1){
			try{
				if (map[currX-2][currY+1] == null){
					map[currX-2][currY+1] = turn;
					x = currX-2;
					y = currY+1;
				}
				else{
					return false;
				}
			}
			catch(Exception e){
				return false;
			}
		}
		else if(attempt == 2){
			try{
				if (map[currX-2][currY-1] == null){
					map[currX-2][currY-1] = turn;
					x = currX-2;
					y = currY-1;
					System.out.println(turn);
				}
				else{
					return false;
				}
			}
			catch(Exception e){
				return false;
			}
		}
		else if(attempt == 3){
			try{
				if (map[currX+2][currY+1] == null){
					map[currX+2][currY+1] = turn;
					x = currX+2;
					y = currY+1;
					System.out.println(turn + " " + attempt);
				}
				else{
					return false;
				}
			}
			catch(Exception e){
				return false;
			}
		}
		else if(attempt == 4){
			try{
				if (map[currX+2][currY-1] == null){
					map[currX+2][currY-1] = turn;
					x = currX+2;
					y = currY-1;
					
				}
				else{
					return false;
				}
			}
			catch(Exception e){
				return false;
			}
		}
		else if(attempt == 5){
			try{
				if(map[currX+1][currY-2] == null){
					map[currX+1][currY-2] = turn;
					x = currX+1;
					y = currY-2;
				}
				else{
					return false;
				}
			}
			catch(Exception e){
				return false;
			}
		}
		else if(attempt == 6){
			try{
				if(map[currX-1][currY-2] == null){
					map[currX-1][currY-2] = turn;
					x = currX-1;
					y = currY-2;
				}
			}
			catch(Exception e){
				return false;
			}
		}
		else if(attempt == 7){
			try{
				if(map[currX+1][currY+2] == null){
					map[currX+1][currY+2] = turn;
					x = currX+1;
					y = currY+2;
				}
				else{
					return false;
				}
			}
			catch(Exception e){
				return false;
			}
		}
		else if(attempt == 8){
			try{
				if(map[currX-1][currY+2] == null){
					map[currX-1][currY+2] = turn;
					x = currX-1;
					y = currY+2;
				}
				else{
					return false;
				}
			}
			catch(Exception e){
				return false;
			}
		}
		
		if (turn == map.length * map.length){
			return true;
		}
		else{
			boolean result = knightsTour(map,x,y,turn+1,1);
			int tries = 1;
			
			while(result == false && tries < 8){
				result = knightsTour(map,x,y,turn+1,tries++);
				
				if(tries == 8){
					System.out.println(turn + "\t" + tries);
					
					for(int i = 0; i < 5; i++) {
						map[x][y] = null;
						for(int j = 0; j < 5; j++) {
							System.out.print(map[j][i] + "\t");
						}
						System.out.println(" \n\n");
					}
				}
			}
			if (result == false && tries == 8){
				//map[x][y] = null;
			}
			return false;
		}
	}
}
