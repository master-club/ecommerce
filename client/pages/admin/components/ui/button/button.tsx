import type { NextPage } from 'next';
import { ReactElement } from 'react';
import * as CSS from 'csstype';

import styles from './button.module.scss';

interface IProps {
  title: string;
  icon?: ReactElement;
  style?: CSS.Properties;
}

const Button: NextPage<IProps> = props => {
  const { title, icon, style } = props;

  return (
    <button className={styles.button} style={style}>
      {icon}
      <span>{title}</span>
    </button>
  );
};

export default Button;
