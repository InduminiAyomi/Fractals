const webdriver = require('webdriverio');

const launch = async () => {
    const webBrowser = await webdriver.remote({
        desiredCapabilities: {
            browserName: 'chrome',
            chromeOptions: {
                args: ['--no-sandbox','--disable-dev-shm-usage']
            }
        }
    }).init();
    
    global.browser = webBrowser;
    return true;
}

module.exports = {
    launch
}