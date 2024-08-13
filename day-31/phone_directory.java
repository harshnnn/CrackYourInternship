class Solution {
    
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
        ArrayList<String> contacts;
        
        TrieNode() {
            isEndOfWord = false;
            contacts = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
    
    static TrieNode root;
    
    static void insert(String contact) {
        TrieNode currentNode = root;
        for (int i = 0; i < contact.length(); i++) {
            int index = contact.charAt(i) - 'a';
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
            currentNode.contacts.add(contact);
        }
        currentNode.isEndOfWord = true;
    }
    
    static ArrayList<String> searchPrefix(String prefix) {
        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (currentNode.children[index] == null) {
                return new ArrayList<>();
            }
            currentNode = currentNode.children[index];
        }
        return currentNode.contacts;
    }
    
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s) {
        root = new TrieNode();
        
        // Insert all contacts into the Trie
        for (String con : contact) {
            insert(con);
        }
        
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        String prefix = "";
        
        // Search for each prefix in the string s
        for (int i = 0; i < s.length(); i++) {
            prefix += s.charAt(i);
            ArrayList<String> contactsWithPrefix = searchPrefix(prefix);
            
            if (contactsWithPrefix.isEmpty()) {
                contactsWithPrefix.add("0");
            } else {
                Collections.sort(contactsWithPrefix);
            }
            
            result.add(contactsWithPrefix);
        }
        
        return result;
    }
}