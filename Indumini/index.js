const Jarvis = require('jarvis');   
const readline = require('readline');
const installDrivers = require('./scripts/installDrivers')
const startInstance = require('./scripts/startInstance')

const launchBrowser = require('./commands/launchBrowser')

const app = new Jarvis();

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
    prompt: 'kasaya> '
});
  
(async () => {
    await installDrivers()
    await startInstance()
    rl.prompt();
})()

rl.on('line', async (line) => {
    const res = await app.send(line.trim());
    // console.log(res);
    rl.prompt();
});

app.addCommand({ command:'launch browser', aliases:['launch browser','open browser'], handler: launchBrowser.launch });