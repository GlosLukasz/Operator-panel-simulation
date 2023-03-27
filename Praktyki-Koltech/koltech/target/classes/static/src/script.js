const buttonStart = document.querySelector('.buttonStart')
const buttonSignOut = document.querySelector('.buttonSignOut')
const basyInformation = document.querySelector('.basyInfo')
const measureInProgress = document.querySelector('.measureInProgress')
const endMesaure = document.querySelector('.endMesaure')
const element1 = document.querySelector('.measurement1')
const element2 = document.querySelector('.measurement2')
const element3 = document.querySelector('.measurement3')
const element4 = document.querySelector('.measurement4')
const element5 = document.querySelector('.measurement5')
const element6 = document.querySelector('.measurement6')
const element7 = document.querySelector('.measurement7')
const element8 = document.querySelector('.measurement8')
const element9 = document.querySelector('.measurement9')
const element10 = document.querySelector('.measurement10')

const clickStart = () => {
    basyInformation.classList.add('hiddenClass')
    measureInProgress.classList.remove('hiddenClass')
    hiddenElements()
    setTimeout(flashingRemove,1000)
    setTimeout(flashingAdd,1000)
    setTimeout(flashingRemove,2000)
    setTimeout(flashingAdd,3000)
    setTimeout(flashingRemove,4000)
    setTimeout(flashingAdd,5000)
    setTimeout(flashingRemove,6000)
    setTimeout(endMesaureFun,7000)

    setTimeout(showElement1,1000)
    setTimeout(showElement2,2000)
    setTimeout(showElement3,4000)
    setTimeout(showElement4,5000)
    setTimeout(showElement5,7000)
    setTimeout(endMesaureShow,11000)
    buttonStart.setAttribute("disabled", true)
    buttonSignOut.setAttribute("disabled", true)
    setTimeout(setStartButtonTrue,7000)
    setTimeout(setSignOutButtonTrue,7000)
}
const flashingAdd = () =>{
    measureInProgress.classList.add('hiddenClass')
}
const setStartButtonTrue = () =>{
    buttonStart.removeAttribute("disabled")
}
const setSignOutButtonTrue = () =>{
    buttonSignOut.removeAttribute("disabled")
}
const flashingRemove = () =>{
    measureInProgress.classList.remove('hiddenClass')
}
const endMesaureShow = () =>{
    endMesaure.classList.add('hiddenClass')
}
const endMesaureFun= () =>{
    measureInProgress.classList.add('hiddenClass')
    basyInformation.classList.remove('hiddenClass')
    endMesaure.classList.remove('hiddenClass')
}
const showElement1 = () => {
    element1.classList.remove('hiddenClass')
    element6.classList.remove('hiddenClass')
}
const showElement2 = () => {
    element2.classList.remove('hiddenClass')
    element7.classList.remove('hiddenClass')
}

const showElement4 = () => {
    element4.classList.remove('hiddenClass')
    element9.classList.remove('hiddenClass')
}

const showElement3 = () => {
    element3.classList.remove('hiddenClass')
    element8.classList.remove('hiddenClass')
}
const showElement5 = () => {
    element5.classList.remove('hiddenClass')
    element10.classList.remove('hiddenClass')
}
const hiddenElements = () => {
    element1.classList.add('hiddenClass')
    element2.classList.add('hiddenClass')
    element3.classList.add('hiddenClass')
    element4.classList.add('hiddenClass')
    element5.classList.add('hiddenClass')
    element6.classList.add('hiddenClass')
    element7.classList.add('hiddenClass')
    element8.classList.add('hiddenClass')
    element9.classList.add('hiddenClass')
    element10.classList.add('hiddenClass')
    endMesaure.classList.add('hiddenClass')
}


window.onload = clickStart()