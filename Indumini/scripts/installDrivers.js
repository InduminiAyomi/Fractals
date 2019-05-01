const selenium = require('selenium-standalone');
const { promisify } = require('util');

const installDrivers = promisify(selenium.install);

module.exports = (async () => {
    try {
        console.log('Installing selenium and browser drivers. please wait...');
        await installDrivers({
            version: '3.141.5',
            baseURL: 'https://selenium-release.storage.googleapis.com',
            drivers: {
                chrome: {
                    version: '2.43',
                    arch: process.arch,
                    baseURL: 'https://chromedriver.storage.googleapis.com'
                }
            },
            requestOpts: { 
                timeout: 10000
            }
        });
        console.log('Installation is complete');
    } catch (e) {
        console.log(e)
        process.exit(-1);
    }
});
