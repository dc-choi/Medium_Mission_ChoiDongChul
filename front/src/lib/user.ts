import { writable } from 'svelte/store';

const createUser = () => {
    const { set, subscribe, update } = writable(true);

    return {
        subscribe,
        login: () => set(true),
        logout: () => set(false),
        toggle: () => update(n => !n)
    };
};

export const user = createUser();
