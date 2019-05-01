const selenium = require('selenium-standalone');
const { promisify } = require('util');

const seleniumStart = promisify(selenium.start);

module.exports = () => seleniumStart({
    version: '3.13.0',
    drivers: {
        chrome: {
            version: '2.40'
            
        }
    }
});
