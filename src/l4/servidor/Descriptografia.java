package l4.servidor;

public class Descriptografia {
	public static String descriptografar(String texto) throws Exception {
		String descriptografado = "";
		char letra;
		char alfabeto [] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c'};
		
		for(int i = 0; i<texto.length(); i++) {
			if(texto.charAt(i)== ' ') {
        		descriptografado += " ";
        	}else if(texto.charAt(i)== ':') {
        		descriptografado += ":";
        	}else {
        		for(int j = 0; j<26; j++) {
    	            if (texto.charAt(i)== alfabeto[j]){
    	            	letra = alfabeto[j-3];
    	            	descriptografado += letra;
     	
    	            	
    	            }
    	            
    	        }
        	}
			
		}
        
        return descriptografado;
        
	}
}
