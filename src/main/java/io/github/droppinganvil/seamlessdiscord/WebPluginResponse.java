package io.github.droppinganvil.seamlessdiscord;

public class WebPluginResponse {
    private boolean response;
    private String message;

    public WebPluginResponse(String s, Boolean response) {
        this.message = s;
        this.response = response;
    }
}
