interface CustomHTMLElement extends HTMLElement {
  submit: () => void,
}

const keyPressEnterEvent = (e: {key: string}) => {
  if (e.key == 'Enter') {
    const form = document.querySelector('.form') as CustomHTMLElement;
    form.submit();
  }
}

export default keyPressEnterEvent;
