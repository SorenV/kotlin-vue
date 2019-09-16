import {SetupFunction} from "./setup";

interface ComponentOptions<PropsOptions, Props> {
    props?: PropsOptions;
    setup?: SetupFunction<Props>;
}
