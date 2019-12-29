package project.jaylee.dartcrawler.config;

/**
 * RunTimeArgs
 * 사용자 실행인자를 읽는 클래스
 */
public class RunTimeArgs {

	public boolean readArgs(String[] args) {
		boolean isValid = true;
		
        int argsLen = args.length;
        if(argsLen == 0) return false;
        
		for (int idx=0; idx<argsLen; idx++) {
            if (!args[idx].startsWith("-")) continue;
			
            if (args[idx].equalsIgnoreCase("-help")) {
            	if (idx+1 >= argsLen || args[idx+1].startsWith("-")) isValid = false;
            	
            } else if (args[idx].equalsIgnoreCase("-log")) {
            	if (idx+1 >= argsLen || args[idx+1].startsWith("-")) isValid = false;
            	
            } else if (args[idx].equalsIgnoreCase("-debug")) {
            	if (idx+1 >= argsLen || args[idx+1].startsWith("-")) isValid = false;
            	
            }
            
		}
		
		return isValid;
	}
	
}
