webView.setWebViewClient(new WebViewClient() {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, android.webkit.WebResourceRequest request) {
        String url = request.getUrl().toString();

        if (url.startsWith("https://wa.me/")
                || url.startsWith("http://wa.me/")
                || url.startsWith("whatsapp://")
                || url.contains("api.whatsapp.com")
                || url.contains("web.whatsapp.com")) {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "WhatsApp install nahi hai", Toast.LENGTH_LONG).show();
            }
            return true;
        }

        return false;
    }
});
