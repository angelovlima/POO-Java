package l4;

public class Criptografia {
	public static String criptografar(String texto) throws Exception {
		String criptografado = "";
		char letra;
		char alfabeto [] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c'};
		
		for(int i = 0; i<texto.length(); i++) {
			if(texto.charAt(i)== ' ') {
        		criptografado += " ";
        	}else if(texto.charAt(i)== ':') {
        		criptografado += ": ";
        	}else {
        		for(int j = 0; j<26; j++) {
    	            if (texto.charAt(i)== alfabeto[j]){
    	            	letra = alfabeto[j+3];
    	            	criptografado += letra;
     	
    	            	
    	            }
    	            
    	        }
        	}
			
		}
        
        return criptografado;
        
	}	
	
}

