package model;

import java.util.HashMap;
import java.util.Map;

/**
 * BDClient
 */
public class BDClient {

    private Map<Integer, Client> listeClient = new HashMap<>();

    private BDClient() {
    }

    private static class BDClientHolder {
        private final static BDClient instance = new BDClient();
    }

    public static BDClient getInstance() {
        return BDClientHolder.instance;
    }

    public void ajouterClient(Client client) {
        listeClient.put(client.getNumClient(), client);
    }

    public String toString() {
        return "BDClient [listeClient=" + listeClient + "]";
    }
}